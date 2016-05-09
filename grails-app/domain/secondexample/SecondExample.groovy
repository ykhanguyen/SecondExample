package secondexample
import metafunctionality.ModuleInput

class SecondExample extends ModuleInput {
    static hasMany = [words: String]
    List words
}
