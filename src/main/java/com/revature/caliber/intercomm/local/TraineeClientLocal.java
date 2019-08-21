package com.revature.caliber.intercomm.local;

import com.revature.caliber.intercomm.base.TraineeClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Profile;

/**
 * @author William Gentry
 * 8/21/2019
 */
@Profile("!dev && !prod")
@FeignClient(name = "user-service")
public interface TraineeClientLocal extends TraineeClient {
}
