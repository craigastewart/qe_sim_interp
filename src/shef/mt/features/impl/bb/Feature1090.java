/**
 *
 */
package shef.mt.features.impl.bb;

import java.util.HashSet;

import shef.mt.features.impl.Feature;
import shef.mt.features.util.Sentence;

/**
 * percentage of nouns in the target
 *
 * @author cat
 *
 */
public class Feature1090 extends Feature {

    public Feature1090() {
        setIndex(1090);
        setDescription("percentage of nouns in the target");
        this.addResource("target.postagger");
    }

    /* (non-Javadoc)
     * @see wlv.mt.features.impl.Feature#run(wlv.mt.features.util.Sentence, wlv.mt.features.util.Sentence)
     */
    @Override
    public void run(Sentence source, Sentence target) {
        // TODO Auto-generated method stub
        float noWords = target.getNoTokens();
        float noNouns = (Integer) target.getValue("nouns");
        setValue(noNouns / noWords);

    }
}
