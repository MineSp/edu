
// /**
//  * 取得cookie
//  * 根据元素name
//  * @param {*} name 元素名字
//  */
// export function getCookie(name) {
//     var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
//     if (arr = document.cookie.match(reg)) { return (arr[2]); }
//     else { return null; }
// }

// /**
//  * 设置cookie,增加到vue实例方便全局调用
//  * @param {*} c_name 元素名字
//  * @param {*} value  元素内容
//  * @param {*} expiredays    保存天数
//  */
// export function setCookie(c_name, value, expiredays) {
//     var exdate = new Date();//获取时间
//     exdate.setDate(exdate.getDate() + expiredays);
//     document.cookie = c_name + "=" + escape(value) + ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString());
// };

// /**
//  * 删除cookie
//  * 根据name删除
//  * @param {*} name 
//  */
// export function delCookie(name) {
//     var exp = new Date();
//     exp.setTime(exp.getTime() - 1);
//     var cval = getCookie(name);
//     if (cval != null)
//         document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
// };

var cookie = {
    set: function (key, val, time) { //设置cookie方法
        var date = new Date(); //获取当前时间
        var expiresDays = time; //将date设置为n天以后的时间
        date.setTime(date.getTime() + expiresDays * 24 * 3600 * 1000); //格式化为cookie识别的时间
        document.cookie = key + "=" + val + ";expires=" + date.toGMTString(); //设置cookie
    },
    get: function (key) { //获取cookie方法
        /*获取cookie参数*/
        var getCookie = document.cookie.replace(/[ ]/g, "$"); //获取cookie，并且将获得的cookie格式化，去掉空格字符，换成$
        getCookie = getCookie.replace(/[;$]/g, ";");
        var arrCookie = getCookie.split(";") //将获得的cookie以"分号"为标识 将cookie保存到arrCookie的数组中
        var tips; //声明变量tips
        // console.info(arrCookie);
        for (var i = 0; i < arrCookie.length; i++) { //使用for循环查找cookie中的tips变量
            var arr = arrCookie[i].split("="); //将单条cookie用"等号"为标识，将单条cookie保存为arr数组
            // console.info("get key=",key,"arr[0]=",arr[0]);
            if (key == arr[0]) { //匹配变量名称，其中arr[0]是指的cookie名称，如果该条变量为tips则执行判断语句中的赋值操作
                tips = arr[1]; //将cookie的值赋给变量tips
                break; //终止for循环遍历
            }
        }
        if (tips) {
            tips = tips.replace(/[$]/g, " "); //还原空格字符串
        }
        // console.info("get key=",key,"value=",tips);
        return tips;
    },
    delete: function (key) { //删除cookie方法
        var date = new Date(); //获取当前时间
        date.setTime(date.getTime() - 10000); //将date设置为过去的时间
        document.cookie = key + "=v; expires =" + date.toGMTString(); //设置cookie
    },
    setArray: function (key, val, time) {
        if (val) {
            val = val.join('-*-');
        }
        // console.info("setArray", this)
        this.set(key, val, time);
    },
    getArray: function (key) {
        var arrayStr = document.cookie.replace(/[ ]/g, "$");
        arrayStr = arrayStr.replace(/[;$]/g, ";");
        // console.info("arrayStr",arrayStr)
        var arrCookie = arrayStr.split(";")
        var tips; //声明变量数组tips

        for (var i = 0; i < arrCookie.length; i++) { //使用for循环查找cookie中的tips变量
            var arr = arrCookie[i].split("="); //将单条cookie用"等号"为标识，将单条cookie保存为arr数组
            // console.info('arrCookie',key == arr[0],arr[0])
            if (key == arr[0]) { //匹配变量名称，其中arr[0]是指的cookie名称，如果该条变量为tips则执行判断语句中的赋值操作
                tips = arr[1]; //将cookie的值赋给变量tips
                if (tips) {
                    tips = tips.replace(/[$]/g, " "); //还原空格字符串
                }
                tips = tips.split("-*-");
                break; //终止for循环遍历
            }
        }
        return tips;
    }
}

export default {
    cookie,
}
