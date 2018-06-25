package mobile;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.Map;

public class RequestUtils {

    public static String requestStr = "{\n" +
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


    static String mobileStr = "{\"preprdid\":\"\",\"trptpe\":1,\"flag\":8,\"searchitem\":[{\"dccode\":\"SHA\",\"accode\":\"OSA\",\"dtime\":\"2018-07-10\"}],\"version\":[{\"Key\":\"170710_fld_dsmid\",\"Value\":\"O\"}],\"psgList\":[{\"type\":1,\"count\":1}],\"token\":\"2\",\"seat\":0,\"segno\":1,\"head\":{\"cid\":\"09031073410302670718\",\"ctok\":\"\",\"cver\":\"1.0\",\"lang\":\"01\",\"sid\":\"8888\",\"syscode\":\"09\",\"auth\":null,\"extension\":[{\"name\":\"aid\",\"value\":\"4897\"},{\"name\":\"sid\",\"value\":\"130026\"},{\"name\":\"protocal\",\"value\":\"https\"}]},\"contentType\":\"json\"}";
    /**
     * 封装post请求的request对象
     * */
    public static Request getRequest(String url, HttpRequestBody requestBody,Map<String,String> headers){
        Request request = new Request();
        request.setMethod(HttpConstant.Method.POST).setUrl(url).setRequestBody(requestBody);
        for(Map.Entry<String,String> entry : headers.entrySet()){
            request.addHeader(entry.getKey(),entry.getValue());
        }
        return request;
    }

    /**
     * 封装post请求体对象
     * */
    public static HttpRequestBody getRequestBody(String jsonStr, String contentType, String encoding){
        return new HttpRequestBody(jsonStr.getBytes(),contentType,encoding);
    }
}
