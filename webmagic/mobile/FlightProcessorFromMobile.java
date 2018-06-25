package mobile;

import com.alibaba.fastjson.JSONObject;
import us.codecraft.webmagic.*;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightProcessorFromMobile implements PageProcessor {
    /**
     * 请求重试次数，抓取间隔
     * */
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setTimeOut(10000);
    @Override
    public void process(Page page) {
        System.out.println(page.getRawText());
    }

    @Override
    public Site getSite() {
        return this.site;
    }

    public static void main(String[] args){
        String data = getData();
        System.out.println(data);

    }

    public static void printInfo(String data){
        ResponseObject obj = JSONObject.parseObject(data, ResponseObject.class);
        List<FlightDetail> fltitem = obj.getFltitem();
        for(FlightDetail detail : fltitem){
            List<Mutilstn> mutilstn = detail.getMutilstn();
            System.out.println();
            for(Mutilstn mu : mutilstn){
                Dportinfo dportinfo = mu.getDportinfo();
                String cityname = dportinfo.getCityname();
                String aportsname = dportinfo.getAportsname();
                Aportinfo aportinfo = mu.getAportinfo();
                String cityname1 = aportinfo.getCityname();
                String aportsname1 = aportinfo.getAportsname();
                DateInfo dateinfo = mu.getDateinfo();
                String ddate = dateinfo.getDdate();
                String adate = dateinfo.getAdate();
                System.out.print("从"+cityname+"-"+aportsname+"到"+cityname1+"-"+aportsname1);
                System.out.print("<"+ddate+"到"+adate+">               ");
            }
            PolicyInfo policyInfo = detail.getPolicyinfo().get(0);
            PriceInfo priceInfo = policyInfo.getPriceinfo().get(0);
            System.out.println("价格:"+(priceInfo.getPrice()+ priceInfo.getTax()));
        }
    }

    private static String getData(){
        String url = "https://m.ctrip.com/restapi/soa2/13212/flightListSearch?_fxpcqlniredt=09031073410302670718";
        Map<String,String> headers = new HashMap<>();
        headers.put("Host","m.ctrip.com");
        headers.put("Origin","https://m.ctrip.com");
        headers.put("X-Requested-With","XMLHttpRequest");
        headers.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36");
        headers.put("Referer","https://m.ctrip.com/html5/flight/swift/international/SHA/OSA/2018-07-10/1-0-0?seat=0&stype=0&ptype=0");
        HttpRequestBody requestBody = RequestUtils.getRequestBody(RequestUtils.mobileStr, "application/json", "UTF-8");
        System.out.println(RequestUtils.mobileStr);
        HttpClientDownloader downloader = new HttpClientDownloader();
        Request request = RequestUtils.getRequest(url, requestBody,headers);
        Page response = downloader.download(request, Spider.create(new FlightProcessorFromMobile()));
        return response.getRawText();
    }

    private static String getYLData(){
        String url = "http://iflight.elong.com/FlightController/list";
        Map<String,String> headers = new HashMap<>();
//        headers.put("Host","iflight.elong.com");
//        headers.put("Origin","http://iflight.elong.com");
//        headers.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36");
        HttpRequestBody requestBody = RequestUtils.getRequestBody(RequestUtils.mobileStr, "application/json", "UTF-8");
        HttpClientDownloader downloader = new HttpClientDownloader();
        Request request = RequestUtils.getRequest(url+Data.str, null,headers);
        Page response = downloader.download(request, Spider.create(new FlightProcessorFromMobile()));
        return response.getRawText();
    }
}
