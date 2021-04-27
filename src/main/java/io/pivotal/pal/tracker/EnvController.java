package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String port;
    private String memoryLimit;
    private String cfInstanceIndex;
    private String cfInstanceAddr;

    public EnvController(@Value("${PORT:NOT SET}") String port,
                         @Value("${MEMORY_LIMIT:NOT SET}") String memLimit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}") String cfIndex,
                         @Value("${CF_INSTANCE_ADDR:NOT SET}") String cfAddr)

    {
        this.port = port;
        memoryLimit = memLimit;
        cfInstanceIndex = cfIndex;
        cfInstanceAddr = cfAddr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv()
    {
        Map<String, String> propMap = new HashMap<String, String>();
        propMap.put("PORT", port);
        propMap.put("MEMORY_LIMIT", memoryLimit);
        propMap.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        propMap.put("CF_INSTANCE_ADDR", cfInstanceAddr);

        return propMap;
    }

}
