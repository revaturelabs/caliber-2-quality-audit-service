package com.revature.caliber.intercomm.perf;

import com.revature.caliber.intercomm.base.BatchClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Profile;

/**
 * @author William Gentry
 */
@Profile("perf")
@FeignClient(name = "batch-service", url = "http://batch.caliber-2-perf")
public interface BatchClientPerf extends BatchClient {
}
