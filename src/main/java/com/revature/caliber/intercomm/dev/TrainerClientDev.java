package com.revature.caliber.intercomm.dev;

import com.revature.caliber.intercomm.base.TrainerClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Profile;

/**
 * @author William Gentry
 * 8/21/2019
 */
@Profile("dev")
@FeignClient(url = "http://user.caliber-2-dev")
public interface TrainerClientDev extends TrainerClient {
}
