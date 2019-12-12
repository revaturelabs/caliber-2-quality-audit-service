package com.revature.caliber.intercomm.perf;

import com.revature.caliber.intercomm.base.TrainerClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Profile;

/**
 * @author William Gentry
 */
@Profile("perf")
@FeignClient(name = "trainer-service", url = "${client.user}")
public interface TrainerClientPerf extends TrainerClient {
}
