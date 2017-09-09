<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>天气</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
    <#if weatherResponse.data??>
    <table class="table">
        <h2>天气预报</h2>
        <thead>
            <tr>
                <th>城市</th>
                <th>温度</th>
                <th>维度</th>
                <th>描述</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${weatherResponse.data.city}</td>
                <td>${weatherResponse.data.wendu!}</td>
                <td>${weatherResponse.data.aqi!}</td>
                <td>${weatherResponse.data.ganmao!}</td>
            </tr>
        </tbody>
    </table>

    <table class="table">
        <caption>昨天的天气情况</caption>
        <thead>
            <tr>
                <th>日期</th>
                <th>高温</th>
                <th>风速</th>
                <th>低温</th>
                <#--<th>级别</th>-->
                <th>类型</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td class="active">${weatherResponse.data.yesterday.date!}</td>
                <td class="success">${weatherResponse.data.yesterday.high!}</td>
                <td class="warning">${weatherResponse.data.yesterday.fx!}</td>
                <td class="danger">${weatherResponse.data.yesterday.low!}</td>
                <#--<td class="danger"><xmp>${weatherResponse.data.yesterday.fl}</xmp></td>-->
                <td class="danger">${weatherResponse.data.yesterday.type!}</td>
            </tr>
        </tbody>
    </table>
    <#if weatherResponse.data.forecast??>
    <table class="table table-condensed">
        <caption>未来的天气情况</caption>
        <thead>
            <tr>
                <th>日期</th>
                <th>高温</th>
                <th>风向</th>
                <th>低温</th>
                <th>类型</th>
            </tr>
        </thead>
        <tbody>
            <#list weatherResponse.data.forecast as forecast>
                <tr>
                    <td>${forecast.date}</td>
                    <td>${forecast.high}</td>
                    <td>${forecast.fengxiang}</td>
                    <td>${forecast.low}</td>
                    <td>${forecast.type}</td>
                </tr>
            </#list>
        </tbody>
    </table>
    </#if>
    </#if>
</body>
</html>