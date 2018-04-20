import $ from "jquery";
import { message, Modal } from "antd";
import createBrowserHistory from 'history/createBrowserHistory'

const history = createBrowserHistory()
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
    static extendJquery(notLoginTodo) {
        if (notLoginTodo) {
            JqueryUtil.notLoginTodo=notLoginTodo
        }
        let _ajax = $.ajax;
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

    }
    /** */
    static checkData(data) {
        if (data.sessionOut) {
            message.warn("请登录",500);
            JqueryUtil.notLoginTodo();
            return false;
        } else if (data.errorCode) {
            message.error(data.message);
            return false;
        }
        return true;
    }
}
