import org.junit.jupiter.api.Test;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.QueueScheduler;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightProcessor implements PageProcessor {

    /**
     * 请求重试次数，抓取间隔
     * */
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    @Override
    public void process(Page page) {
//        http://webresource.c-ctrip.com/ResFltIntlOnline/R17/assets/list.js
        if(page.getUrl().regex("http://webresource.c-ctrip.com/[a-z 0-9 -]+/[a-z A-Z 0-9 /]*.js").match()){
            //加入满足条件的链接
            page.addTargetRequests(
                    page.getHtml().xpath(".*").all());
        }else{
            //获取页面需要的内容
            System.out.println("抓取的内容："+
                    page.getRawText()
            );
        }
    }

    @Override
    public Site getSite() {
        return this.site;
    }

    public static void main(String[] args){
        /**
         * 必要请求参数
         * */
//        String url = "http://flights.ctrip.com/international/search/api/search/batchSearch";
        String url = "http://flights.ctrip.com/international/search/oneway-sha-sel?depdate=2018-6-20&cabin=y&adult=1";
        String jsonStr = RequestUtils.requestStr;
        String contentType = "application/json";
        String encoding = "UTF-8";


        FlightProcessor flightProcessor = new FlightProcessor();
        HttpRequestBody requestBody = RequestUtils.getRequestBody(jsonStr, contentType, encoding);
        Map<String, String> headers = new HashMap<>();
        headers.put("sign","a411a1e2e85a1e511e1de3597319451c");
        headers.put("transactionID","j025dd02d8410420a96cc9bd2193d3ebd");
        Request request = RequestUtils.getRequest(url, requestBody,headers);
//        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        QueueScheduler queueScheduler = new QueueScheduler();
        Spider spider = Spider.create(flightProcessor);
        queueScheduler.pushWhenNoDuplicate(request,spider);
        spider.setScheduler(queueScheduler);
        spider.run();
        String urlStr = "https://webresource.c-ctrip.com/ResCRMOnline/R6/member/common/js/mask_young.js?20171130";

//        Page result = httpClientDownloader.download(request, spider);
//        System.out.println(result.getRawText());

    }

    @Test
    public void testRegex(){
        Pattern pattern = Pattern.compile("https://webresource.c-ctrip.com/[a-z A-Z 0-9 /]*[.]js");
        Matcher matcher = pattern.matcher("https://webresource.c-ctrip.com/ResCRMOnline/R6/member/common/js/mask_young.js?20171130");
        if(matcher.find()){

            System.out.println(matcher.group(0));
        }
    }
}
