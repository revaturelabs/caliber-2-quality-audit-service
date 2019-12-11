package com.revature.caliber.intercomm.perf;

import com.revature.caliber.intercomm.base.TraineeClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Profile;

/**
 * @author William Gentry
 */
@Profile("local")
@FeignClient(name = "trainee-service", url = "http://user.caliber-2-perf")
public interface TraineeClientPerf extends TraineeClient {
}
