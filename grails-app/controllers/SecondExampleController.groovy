import secondexample.SecondExample
import metafunctionality.Module
import metafunctionality.ModuleOutput

class SecondExampleController {
	def start() {
		String inputID = Module.findByModuleId(params.id).inputID;
		SecondExample input = SecondExample.findByModuleDataID(inputID)
		List<String> rc = input.words
		//Store module in saveModuleService
		[words: words]
	}
	
	def submit() {
   	 List<String> valueRows = new ArrayList<String>()
   	 ModuleOutput output = new ModuleOutput()
   	 output.headers = ["word", "accuracy"]

  	  output.valueRows = params.data

 	   Module m = Module.findByModuleIP(params.id)//load from saveModuleService
 	   if (m.outputIDs != null) {
	        m.outputIDs.add(output.moduleDataID)
 	   } else {
 	     	  m.outputIDs = [output.moduleDataID]
  	  }
   	 output.type = "SecondExample"
   	 m.save(flush: true)
  	 output.save(flush: true)

   	 //redirect to learner home
 	 redirect(controller: "appforliteracy.FileOutput", action: "output", params:     [id: output.moduleDataID])
}
}
