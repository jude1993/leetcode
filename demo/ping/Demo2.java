package ping;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.ArrayList;


/**
 * @author jude
 */
public class Demo2 implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    private static int count = 0;
    @Override
    public void process(Page page) {
        //判断链接是否符合http://www.cnblogs.com/任意个数字字母-/p/7个数字.html格式
        if(!page.getUrl().regex("http://www.cnblogs.com/[a-z 0-9 -]+/p/[0-9]{7}.html").match()){
            //加入满足条件的链接
            page.addTargetRequests(
                    page.getHtml().xpath("//*[@id=\"post_list\"]/div/div[@class='post_item_body']/h3/a/@href").all());
        }else{
      // 获取页面需要的内容
      System.out.println("抓取的内容：" + page.getHtml().xpath("//*[@id=\"speedtest_v4\"]").get());
            count ++;
        }
    }

    @Override
    public Site getSite() {
        return this.site;
    }

    public static void main(String[] args){
        long startTime, endTime;
        System.out.println("开始爬取...");
        startTime = System.currentTimeMillis();
        Request request = new Request("https://www.vultr.com/faq/#downloadspeedtests");
        HttpClientDownloader downloader = new HttpClientDownloader();
        Page respon = downloader.download(request, Spider.create(new Demo2()));
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了"+count+"条记录");
    }
}