package com.revature.caliber.intercomm.local;

import com.revature.caliber.intercomm.base.CategoryClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Profile;

/**
 * @author William Gentry
 * 8/21/2019
 */
@Profile("local")
@FeignClient(name = "category-service")
public interface CategoryClientLocal extends CategoryClient {
}
