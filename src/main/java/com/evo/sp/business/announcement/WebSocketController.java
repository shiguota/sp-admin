package com.evo.sp.business.announcement;

import com.evo.sp.common.result.Result;
import com.evo.sp.config.websocket.WebSocketServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * <p>
 *  WebSocketController
 * </p>
 *
 * @author sgt
 * @since 2019-04-24 16:19
 */

@RestController
@RequestMapping("/socket")
public class WebSocketController {

    //页面请求
    @PostMapping("/socket/{cid}")
    public Result socket(String cid) {
        System.out.println("页面请求已接收"+cid);
        return new Result(false);
    }
    //推送数据接口
    @PostMapping("/socket/push/{cid}")
    public Result pushToWeb(String cid,String message) {
        try {
            WebSocketServer.sendInfo(message,cid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
