import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MyProcessor2 implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    private static int count = 0;
    @Override
    public void process(Page page) {
        page.addTargetRequests(Collections.singletonList("http://flights.ctrip.com/international/search/api/search/batchSearch"));
        //判断链接是否符合http://www.cnblogs.com/任意个数字字母-/p/7个数字.html格式

        //获取页面需要的内容
            System.out.println("抓取的内容："+ page.getRawText());
    }

    @Override
    public Site getSite() {
        return this.site;
    }

    public static void main(String[] args){
        long startTime, endTime;
        System.out.println("开始爬取...");
        startTime = System.currentTimeMillis();
//        Spider.create(new MyProcessor2()).addUrl("").thread(5).run();
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        int nums = 0;
        for(int i =0; i<1; i++){
            Request request = getRequest("http://flights.ctrip.com/international/search/api/search/batchSearch");
            HttpClientDownloader downloader = new HttpClientDownloader();
            Page respon = downloader.download(request, Spider.create(new MyProcessor2()));
//            System.out.println(nums++);
            System.out.println(respon.getRawText());
        }
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了"+count+"条记录");
    }

    public static Request getRequest(String url){
        Request request = new Request(url);
        request.setMethod(HttpConstant.Method.POST);
        request.setExtras(null);
        request.setPriority(1);
        byte[] content = new byte[]{};
        String str = "{\n" +
                "    \"flightWayEnum\": \"OW\",\n" +
                "    \"arrivalProvinceId\": 0,\n" +
                "    \"arrivalCountryName\": \"韩国\",\n" +
                "    \"infantCount\": 0,\n" +
                "    \"cabin\": \"Y\",\n" +
                "    \"cabinEnum\": \"Y\",\n" +
                "    \"departCountryName\": \"中国\",\n" +
                "    \"flightSegments\": [\n" +
                "        {\n" +
                "            \"departureDate\": \"2018-06-20\",\n" +
                "            \"arrivalProvinceId\": 0,\n" +
                "            \"arrivalCountryName\": \"韩国\",\n" +
                "            \"departureCityName\": \"上海\",\n" +
                "            \"departureCityCode\": \"SHA\",\n" +
                "            \"departureCountryName\": \"中国\",\n" +
                "            \"arrivalCityName\": \"首尔\",\n" +
                "            \"arrivalCityCode\": \"SEL\",\n" +
                "            \"arrivalCountryId\": 42,\n" +
                "            \"timeZone\": 480,\n" +
                "            \"departureCityId\": 2,\n" +
                "            \"departureCountryId\": 1,\n" +
                "            \"departureProvinceId\": 2,\n" +
                "            \"arrivalCityId\": 274\n" +
                "        }\n" +
                "    ],\n" +
                "    \"childCount\": 0,\n" +
                "    \"segmentNo\": 1,\n" +
                "    \"adultCount\": 1,\n" +
                "    \"transactionID\": \"jcf39143942f24518a8c43226c33a697e\",\n" +
                "    \"directFlight\": false,\n" +
                "    \"isMultiplePassengerType\": 0,\n" +
                "    \"flightWay\": \"S\",\n" +
                "    \"departProvinceId\": 2\n" +
                "}";
        HttpRequestBody requestBody = new HttpRequestBody(str.getBytes(), "application/json", "UTF-8");
        request.setRequestBody(requestBody);
//        request.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36")
                request.addHeader("transactionID","j025dd02d8410420a96cc9bd2193d3ebd")
                .addHeader("sign","a411a1e2e85a1e511e1de3597319451c");
//        request.addCookie("_abtest_userid","f08b7265-40c8-4a91-ab7a-99ac9f7221a2; FlightIntl=Search=[%22SHA|%E4%B8%8A%E6%B5%B7(SHA)|2|SHA|480%22%2C%22SEL|%E9%A6%96%E5%B0%94(SEL)|274|SEL|480%22%2C%222018-06-20%22]; _ga=GA1.2.853339738.1527669824; _gid=GA1.2.800679254.1527669824; MKT_Pagesource=PC; _RSG=Xc4qh6BGNzAPii2MMlGxxB; _RDG=28c017f5645f1523842e87a2428fed053e; _RGUID=af5740b1-abd0-49a1-befb-42f5960acb19; _RF1=116.234.223.237; _bfi=p1%3D10320672927%26p2%3D0%26v1%3D3%26v2%3D0; _bfa=1.1527669820282.4cquoz.1.1527669820282.1527693888408.2.4; _bfs=1.2; _jzqco=%7C%7C%7C%7C%7C1.158918705.1527669825401.1527693893147.1527694041162.1527693893147.1527694041162.0.0.0.4.4; __zpspc=9.2.1527693893.1527694041.2%234%7C%7C%7C%7C%7C%23");
        return request;
    }
}
