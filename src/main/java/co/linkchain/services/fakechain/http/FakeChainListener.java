package co.linkchain.services.fakechain.http;

import co.linkchain.services.fakechain.FakeChainService;
import org.springframework.web.bind.annotation.*;

@RestController
public class FakeChainListener {

    @RequestMapping(value = "/transactions", method = RequestMethod.POST)
    public Long addTransaction(@RequestBody String raw) {
        return FakeChainService.template.postForEntity("http://localhost:8084/db/temp/add", raw, Long.class).getBody();
    }

    @RequestMapping(value = "/transactions/get", method = RequestMethod.GET)
    public String getTransaction(@RequestParam("id") long id) {
        return FakeChainService.template.getForEntity("http://localhost:8084/db/temp/get?id=" + id, String.class).getBody();
    }

}
