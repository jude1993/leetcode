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


    static String mobileStr = "{\n" +
            "    \"preprdid\": \"\",\n" +
            "    \"trptpe\": 1,\n" +
            "    \"flag\": 8,\n" +
            "    \"searchitem\": [\n" +
            "        {\n" +
            "            \"dccode\": \"SHA\",\n" +
            "            \"accode\": \"SEL\",\n" +
            "            \"dtime\": \"2018-06-14\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"version\": [\n" +
            "        {\n" +
            "            \"Key\": \"170710_fld_dsmid\",\n" +
            "            \"Value\": \"O\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"psgList\": [\n" +
            "        {\n" +
            "            \"type\": 1,\n" +
            "            \"count\": 1\n" +
            "        }\n" +
            "    ],\n" +
            "    \"token\": \"2\",\n" +
            "    \"seat\": 0,\n" +
            "    \"segno\": 1,\n" +
            "    \"tid\": \"{64b431ca-4a5d-4e15-b923-33a3b2283540}\",\n" +
            "    \"head\": {\n" +
            "        \"cid\": \"09031073410302670718\",\n" +
            "        \"ctok\": \"\",\n" +
            "        \"cver\": \"1.0\",\n" +
            "        \"lang\": \"01\",\n" +
            "        \"sid\": \"8888\",\n" +
            "        \"syscode\": \"09\",\n" +
            "        \"auth\": null,\n" +
            "        \"extension\": [\n" +
            "            {\n" +
            "                \"name\": \"aid\",\n" +
            "                \"value\": \"4897\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"name\": \"sid\",\n" +
            "                \"value\": \"130026\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"name\": \"protocal\",\n" +
            "                \"value\": \"https\"\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"contentType\": \"json\"\n" +
            "}";
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
