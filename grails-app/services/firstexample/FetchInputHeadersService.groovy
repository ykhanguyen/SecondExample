package firstexample

class FetchInputHeadersService {
    def getHeaders () {
        Map<String, String> headers = new LinkedHashMap<>()
        headers.put("words", "[String]")
        return headers
    }
}
