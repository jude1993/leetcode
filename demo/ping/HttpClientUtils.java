package ping;//

import com.alibaba.fastjson.JSONObject;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jude
 */
public final class HttpClientUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);
    public static final String ENCODING = "UTF-8";

    public HttpClientUtils() {
    }

    public static String post(HashMap<String, String> map, String uri) {
        uri = StringUtils.trimToEmpty(uri);
        if (map != null && map.size() != 0) {
            if (StringUtils.isBlank(uri)) {
                logger.error("post param uri 不能为空");
                return null;
            } else {
                ArrayList params = new ArrayList();

                for (Object o : map.entrySet()) {
                    Entry e = (Entry) o;
                    params.add(new BasicNameValuePair(StringUtils.trimToEmpty((String) e.getKey()), StringUtils.trimToEmpty((String) e.getValue())));
                }

                HttpPost httpPost = new HttpPost();
                HttpEntity httpEntity = null;
                String result = null;

                try {
                    httpPost.setURI(URI.create(uri));
                    httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
                    httpEntity = (new DefaultHttpClient()).execute(httpPost).getEntity();
                    result = EntityUtils.toString(httpEntity, "UTF-8");
                    logger.info(String.format("httpclient post result=%s", result));
                } catch (Exception var15) {
                    logger.warn("post {} 请求失败, result={}, map={}, e={}", new Object[]{uri, result, map.toString(), var15.getStackTrace()});
                } finally {
                    httpPost.abort();

                    try {
                        EntityUtils.consume(httpEntity);
                    } catch (Exception var14) {
                        logger.error("post error", var14);
                    }

                }

                return result;
            }
        } else {
            logger.error("post param map 不能为空");
            return null;
        }
    }

    public static String get(String uri) {
        uri = StringUtils.trimToEmpty(uri);
        if (StringUtils.isBlank(uri)) {
            logger.error("get param uri 不能为空");
            return null;
        } else {
            HttpGet httpGet = new HttpGet();
            HttpEntity httpEntity = null;
            String result = null;

            try {
                httpGet.setURI(URI.create(uri));
                httpEntity = (new DefaultHttpClient()).execute(httpGet).getEntity();
                result = EntityUtils.toString(httpEntity, "UTF-8");
                logger.info(String.format("httpclient get result=%s", result));
            } catch (Exception var13) {
                logger.warn("get {} 请求失败, result={}, e={}", new Object[]{uri, result, var13.getStackTrace()});
            } finally {
                httpGet.abort();

                try {
                    EntityUtils.consume(httpEntity);
                } catch (Exception var12) {
                    logger.error("get error", var12);
                }

            }

            return result;
        }
    }

    public static String get(String uri, String encoding) {
        uri = StringUtils.trimToEmpty(uri);
        if (StringUtils.isBlank(uri)) {
            logger.error("get param uri 不能为空");
            return null;
        } else {
            HttpGet httpGet = new HttpGet();
            HttpEntity httpEntity = null;
            String result = null;

            try {
                httpGet.setURI(URI.create(uri));
                httpEntity = (new DefaultHttpClient()).execute(httpGet).getEntity();
                result = EntityUtils.toString(httpEntity, encoding);
                logger.info(String.format("httpclient get result=%s", result));
            } catch (Exception var14) {
                logger.warn("get {} 请求失败, result={}, e={}", new Object[]{uri, result, var14.getStackTrace()});
            } finally {
                httpGet.abort();

                try {
                    EntityUtils.consume(httpEntity);
                } catch (Exception var13) {
                    logger.error("get error", var13);
                }

            }

            return result;
        }
    }

    public static String postJson(HashMap<String, String> map, String uri) {
        uri = StringUtils.trimToEmpty(uri);
        if (map != null && map.size() != 0) {
            if (StringUtils.isBlank(uri)) {
                logger.error("post param uri 不能为空");
                return null;
            } else {
                HttpPost httpPost = new HttpPost(uri);
                HttpEntity httpEntity = null;
                String result = null;
                CloseableHttpClient httpClient = HttpClients.createDefault();
                BasicResponseHandler responseHandler = new BasicResponseHandler();

                try {
                    StringEntity requestEntity = new StringEntity(JSONObject.toJSONString(map), "utf-8");
                    requestEntity.setContentEncoding("UTF-8");
                    httpPost.setHeader("Content-type", "application/json");
                    httpPost.setEntity(requestEntity);
                    result = (String)httpClient.execute(httpPost, responseHandler);
                    logger.info(String.format("httpclient post result=%s", result));
                } catch (Exception var16) {
                    var16.printStackTrace();
                    logger.warn("post {} 请求失败, result={}, map={}, e={}", new Object[]{uri, result, map.toString(), var16.getStackTrace()});
                } finally {
                    httpPost.abort();

                    try {
                        EntityUtils.consume((HttpEntity)httpEntity);
                    } catch (Exception var15) {
                        logger.error("post error", var15);
                    }

                }

                return result;
            }
        } else {
            logger.error("post param map 不能为空");
            return null;
        }
    }

    public static String postJson(String uri, String body) {
        uri = StringUtils.trimToEmpty(uri);
        if (StringUtils.isBlank(body)) {
            logger.error("post param body 不能为空");
            return null;
        } else if (StringUtils.isBlank(uri)) {
            logger.error("post param uri 不能为空");
            return null;
        } else {
            HttpPost httpPost = new HttpPost(uri);
            HttpEntity httpEntity = null;
            String result = null;
            CloseableHttpClient httpClient = HttpClients.createDefault();
            BasicResponseHandler responseHandler = new BasicResponseHandler();

            try {
                StringEntity requestEntity = new StringEntity(body, "utf-8");
                requestEntity.setContentEncoding("UTF-8");
                httpPost.setHeader("Content-type", "application/json");
                httpPost.setEntity(requestEntity);
                result = (String)httpClient.execute(httpPost, responseHandler);
                logger.info(String.format("httpclient post result=%s", result));
            } catch (Exception var16) {
                var16.printStackTrace();
                logger.warn("post {} 请求失败, result={}, map={}, e={}", new Object[]{uri, result, body, var16.getStackTrace()});
            } finally {
                httpPost.abort();

                try {
                    EntityUtils.consume((HttpEntity)httpEntity);
                } catch (Exception var15) {
                    logger.error("post error", var15);
                }

            }

            return result;
        }
    }

    public static String postByContentType(HashMap<String, String> map, String uri, String contentType) {
        uri = StringUtils.trimToEmpty(uri);
        if (map != null && map.size() != 0) {
            if (StringUtils.isBlank(uri)) {
                logger.error("post param uri不能为空");
                return null;
            } else if (StringUtils.isBlank(contentType)) {
                logger.error("post contentType不能为空");
                return null;
            } else {
                HttpPost httpPost = new HttpPost(uri);
                HttpEntity httpEntity = null;
                String result = null;
                CloseableHttpClient httpClient = HttpClients.createDefault();
                BasicResponseHandler responseHandler = new BasicResponseHandler();

                try {
                    if (HttpClientUtils.RequestContentType.json.getCode().equals(contentType)) {
                        StringEntity requestEntity = new StringEntity(JSONObject.toJSONString(map), "utf-8");
                        httpPost.setEntity(requestEntity);
                    } else if (HttpClientUtils.RequestContentType.x_www_form_urlencoded.getCode().equals(contentType)) {
                        List<NameValuePair> params = new ArrayList();
                        Iterator var9 = map.entrySet().iterator();

                        while(var9.hasNext()) {
                            Entry<String, String> entry = (Entry)var9.next();
                            params.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue()));
                        }

                        httpPost.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
                    }

                    httpPost.setHeader("Content-type", contentType);
                    result = (String)httpClient.execute(httpPost, responseHandler);
                    logger.info(String.format("httpclient post result=%s", result));
                } catch (Exception var19) {
                    logger.warn("post {} 请求失败, result={}, map={}, e={}", new Object[]{uri, result, map.toString(), var19.getStackTrace()});
                } finally {
                    httpPost.abort();

                    try {
                        EntityUtils.consume((HttpEntity)httpEntity);
                    } catch (Exception var18) {
                        logger.error("post error", var18);
                    }

                }

                return result;
            }
        } else {
            logger.error("post param map不能为空");
            return null;
        }
    }

    static enum RequestContentType {
        x_www_form_urlencoded("application/x-www-form-urlencoded"),
        json("application/json");

        private String code;

        private RequestContentType(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }
    }
}
