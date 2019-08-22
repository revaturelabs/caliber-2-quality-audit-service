package com.revature.caliber.intercomm.dev;

import com.revature.caliber.intercomm.base.TraineeClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Profile;

/**
 * @author William Gentry
 * 8/21/2019
 */
@Profile("dev")
@FeignClient(name = "user-client", url = "http://user.caliber-2-dev")
public interface TraineeClientDev extends TraineeClient {
}
