package com.feurle.ai.chat;

import org.junit.jupiter.api.Test;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
@TestPropertySource(properties = {
        "spring.ai.mcp.client.sse.connections.openhab.url=",
        "spring.ai.mcp.client.enabled=false"
})
class ChatApplicationTests {

    // mock MCP-client → no real connection when testing
    @MockitoBean
    SyncMcpToolCallbackProvider syncMcpToolCallbackProvider;

    @Test
    void contextLoads() {
    }

}
