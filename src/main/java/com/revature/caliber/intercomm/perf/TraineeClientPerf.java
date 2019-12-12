package com.revature.caliber.intercomm.perf;

import com.revature.caliber.intercomm.base.TraineeClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Profile;

/**
 * @author William Gentry
 */
@Profile("perf")
@FeignClient(name = "trainee-service", url = "${client.user}")
public interface TraineeClientPerf extends TraineeClient {
}
