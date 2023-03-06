// 参数 args 是一个 JS 对象, 里面包含了以下属性
// method: 请求方法
// url: 请求路径
// body: 请求的正文数据
// contentType: 请求正文的格式
// callback: 处理响应的回调函数, 有两个参数, 响应正文和响应的状态码
function ajax(args) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
// 0: 请求未初始化
// 1: 服务器连接已建立
// 2: 请求已接收
// 3: 请求处理中
// 4: 请求已完成，且响应已就绪
        if (xhr.readyState == 4) {
            args.callback(xhr.responseText, xhr.status)
        }
    }
    xhr.open(args.method, args.url);
    if (args.contentType) {
        xhr.setRequestHeader('Content-type', args.contentType);
    }
    if (args.body) {
        xhr.send(args.body);
    } else {
        xhr.send();
    }
}