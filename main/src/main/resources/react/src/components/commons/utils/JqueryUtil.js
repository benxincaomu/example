import $ from "jquery";
import {message} from "antd";
import {hashHistory} from "react-router";
export default class JqueryUtil {
    static post(url, params, success) {
        
        $.post(url, params, function (data,textStatus,jqXHR) {
            
            if(data.sessionOut){
                message.warn("请重新登陆");
                hashHistory.push("/login");
            }else if(success){
                success(data);
            }

        }, "json")
    }
    static checkLogin(){
       JqueryUtil.post("./web/check/session",{});
    }
}
