package com.revature.caliber.intercomm.perf;

import com.revature.caliber.intercomm.base.CategoryClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Profile;

/**
 * @author William Gentry
 */
@Profile("perf")
@FeignClient(name = "category-service", url = "http://category.caliber-2-perf")
public interface CategoryClientPerf extends CategoryClient {
}
