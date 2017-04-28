import $ from "jquery";
import { message } from "antd";
import { hashHistory } from "react-router";
export default class JqueryUtil {
    static post(url, params, success, type) {

        $.post(url, params, function (data, textStatus, jqXHR) {

            success(data);

        }, type ? type : "json")
    }
    static checkLogin() {
        JqueryUtil.post("./web/check/session", {}, null, "");
    }

    /** 对jquery中常用的ajax */
    static extendJquery() {
        let _ajax = $.ajax, _get = $.get, _post = $.post;
        $.ajax = function (settings) {
            if (settings.success) {
                let _success = settings.success;
                settings.success = (data, textStatus, jqXHR) => {
                    if (JqueryUtil.checkData(data)) {
                        _success(data, textStatus, jqXHR)
                    }
                }
            }
            _ajax(settings);
        }
        $.get = (url, data, success, dataType) => {
            if (success) {
                let _success = success;
                success = (url, data, success, dataType) => {
                    if (JqueryUtil.checkData(data)) {
                        _success(url, data, success, dataType);
                    }
                }
            }
            _get(url,data,success,dataType);
        }
        $.post=(url, data, success, dataType) => {
            if (success) {
                let _success = success;
                success = (url, data, success, dataType) => {
                    if (JqueryUtil.checkData(data)) {
                        _success(url, data, success, dataType);
                    }
                }
            }
            _post(url,data,success,dataType);
        }

    }
    /** */
    static checkData(data) {
        if (data.sessionOut) {
            message.warn("请登录");
            hashHistory.push("/login");
            return false;
        } else if (data.errorCode) {
            message.error(data.message);
            return false;
        }
        return true;
    }
}
