/** OtagoParser.java
* Parses the Otago HTML API to generate a University Object
*
* @author H Paterson
* @version 1
*/

public class OtagoParser implements ParserInterface {

    public University queryUniversity() {
        University otagoUniversity = new University();
        otagoUniversity.setName("Otago University");
        otagoUniversity.setLocation("Dunedin");
        return null;
    }

}