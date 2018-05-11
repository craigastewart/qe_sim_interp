/*
 *
 */
package shef.mt.features.impl.bb;

import java.util.HashSet;
import java.lang.Math;

import shef.mt.features.impl.Feature;
import shef.mt.features.util.Sentence;
import shef.mt.tools.FileModel;
import shef.mt.tools.TopicDistributionProcessor;

/**
 * Feature 1301 is the Jensen-Shannon divergence between a source sentence and a target sentence topic distribution
 *
 * @author Raphael Rubino
 *
 */
public class Feature1301 extends Feature {

    /** 
    *
    */
    public Feature1301() {
        setIndex("1301");
        setDescription("Jensen-Shannon divergence of source and target topic distributions");
        this.addResource("source.topic.distribution");
        this.addResource("target.topic.distribution");
    }

    /**
    * @param    source	Sentence object of the source sentence 
    * @param	target	Sentence object of the target sentence
    *
    */
    @Override
    public void run(Sentence source, Sentence target) {
	Float[] sourceTopicVector = (Float[]) source.getValue("topicDistribution");
	Float[] targetTopicVector = (Float[]) target.getValue("topicDistribution");
	Float jsDiv = jsDivergence( sourceTopicVector, targetTopicVector );
	setValue( jsDiv );
    }

    /**
    * @param    sourceVector	Float[] containing the topic distribution of the source sentence
    * @param	targetVector	Float[] containing the topic distribution of the target sentence
    * @return		Float contining the Jensen-Shannon divergence between the source and the target topic distribution
    *
    */
    public Float jsDivergence(Float[] sourceVector, Float[] targetVector) {
	assert(sourceVector.length == targetVector.length);
	Float[] average = new Float[sourceVector.length];
	for (int i = 0 ; i < sourceVector.length ; i++) {
		Float sourceValue = sourceVector[i];
		Float targetValue = targetVector[i];
		average[i] = (sourceValue + targetValue)/2;
	}
	return (klDivergence(sourceVector, average) + klDivergence(targetVector, average))/2;
    }

    /**
    * @param    sourceVector    Float[] containing the topic distribution of the source sentence
    * @param    targetVector    Float[] containing the topic distribution of the target sentence
    * @return           Float containing the Kullback-Leibler divergence between the source and the target topic distribution
    *
    */
    public Float klDivergence(Float[] sourceVector, Float[] targetVector) {
	Float klDiv = 0.0f;
	for (int i = 0; i < sourceVector.length; ++i) {
		if (sourceVector[i] == 0.0f) { continue; }
		if (targetVector[i] == 0.0f) { continue; }
		Float ratio = new Float( Math.log( sourceVector[i] / targetVector[i] ) );
		klDiv += sourceVector[i] * ratio;
	}
	return klDiv / new Float( Math.log( 2 ) );
    }

}
