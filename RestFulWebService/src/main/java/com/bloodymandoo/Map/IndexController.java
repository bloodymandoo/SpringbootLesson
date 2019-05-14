package com.bloodymandoo.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/")
    String get(){
        return "Hello from get";
    }

    @RequestMapping("/index")
    String index(){
        return "Hello from index";
    }

    @RequestMapping(value = {
            "",
            "/page",
            "page*",
            "view/*,**/msg"
    })
    String indexMultipleMapping(){
        return "Hello from index multiple mapping";
    }

    @RequestMapping(value="/id")
    String getIdByValue(@RequestParam("id")String personId){
        return "Get ID from query string of URL with value element";
    }

    @RequestMapping(value="/personId")
    String getId(@RequestParam String personId){
        return "Get ID from query string of URL without value element";
    }

    @RequestMapping(value = "/name")
    String getName(@RequestParam(value="person",required = false)String personName){
        return "Required element of request param";
    }

    @RequestMapping(value = "/name")
    String getDeName(@RequestParam(value = "person",defaultValue = "John")String personName){
        return "Required element of request param";
    }


    @RequestMapping(method = RequestMethod.GET)
    String getMethod(){
        return "Hello from get";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    String deleteMethod(){
        return "Hello from delete";
    }

    @RequestMapping(method = RequestMethod.POST)
    String postMethod(){
        return "Hello from post";
    }

    @RequestMapping(method = RequestMethod.PUT)
    String putMethod(){
        return "Hello from put";
    }

    @RequestMapping(method = RequestMethod.PATCH)
    String patch(){
        return "Hello from patch";
    }

    @RequestMapping(value = "/prod",produces = {
            "application/JSON"
    })
    @ResponseBody
    String getProduces(){
        return "Produces attribute";
    }

    @RequestMapping(value = "/cons",consumes = {
            "application/JSON",
            "application/XML"
    })
    String getConsumes(){
        return "Consumes attribute";
    }

    @RequestMapping(value = "/head",headers={
            "content-type=text/plain"
    })
    String postHeader(){
        return "Mapping applied along with headers";
    }

    @RequestMapping(value = "/head",headers = {
            "content-type=text/plain",
            "content-type=text/html"
    })
    String postHeaders(){
        return "Mapping applied along with headers";
    }

    @RequestMapping(value = "/fetch",params = {
            "personId=10"
    })
    String getParams(@RequestParam("personId")String id){
        return "Fetch parameter using params attribute = " + id;
    }

    @RequestMapping(value = "/fetch",params = {
            "personId=20"
    })
    String getParamsDifferent(@RequestParam("personId")String id){
        return "Fetched parameter using params attribute = " + id;
    }

    @RequestMapping(value = "/fetch/{id}",method = RequestMethod.GET)
    String getDynamicUriValue(@PathVariable String id){
        return "Dynamic URI parameter fetched";
    }

    @RequestMapping(value = "/fetch/{id:[a-z]+}/{name}",method = RequestMethod.GET)
    String getDynamicUriValueRegex(@PathVariable("name")String name){
        return "Dynamic URI parameter fetched using regex";
    }

    @GetMapping("/home")
    public @ResponseBody
    ResponseEntity<String>getPerson(){
        return new ResponseEntity<String>("Response from GET", HttpStatus.OK);
    }

    @PostMapping("/home")
    public @ResponseBody ResponseEntity<String>postPerson(){
        return new ResponseEntity<String>("Resopnse from POST method",HttpStatus.OK);
    }

    @PutMapping("/home")
    public @ResponseBody ResponseEntity<String>putPerson(){
        return new ResponseEntity<String>("Resopnse from PUT method",HttpStatus.OK);
    }

    @DeleteMapping("/home")
    public @ResponseBody ResponseEntity<String>deletePerson(){
        return new ResponseEntity<String>("Resopnse from DELETE method",HttpStatus.OK);
    }

    @PatchMapping("/home")
    public @ResponseBody ResponseEntity<String>patchPerson(){
        return new ResponseEntity<String>("Resopnse from PATCH method",HttpStatus.OK);
    }
}
