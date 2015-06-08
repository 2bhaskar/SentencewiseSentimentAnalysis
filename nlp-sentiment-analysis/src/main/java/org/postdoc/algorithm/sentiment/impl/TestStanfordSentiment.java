package org.postdoc.algorithm.sentiment.impl;

import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

public class TestStanfordSentiment {
		
	private static final String ANNOTATORS = "annotators";
	private static final String PIPELINE_PARAMS = "tokenize, ssplit, parse, sentiment";
	private static final String[] SENTIMENT_VALUES = {"Very Negative", "Negative", "Neutral",
													"Positive", "Very Positive", "Unknown value"}; 
	
	private static Properties props;
	private static StanfordCoreNLP pipeline;
	
	private static String text = "This is s sample sentence.";
	
	public static void main(String[] args){
		
		/* Setting up the pipeline */
		init();
		/* Perform sentiment analysis*/
		performSentimentAnalysis();
	}
	
	private static void init() {
		props = new Properties();
		props.setProperty(ANNOTATORS, PIPELINE_PARAMS);
		pipeline = new StanfordCoreNLP(props);
	}
	
	private static void performSentimentAnalysis() {
		/* Create an empty Annotation just with the given text*/
		Annotation document = new Annotation(text);
		pipeline.annotate(document);
		System.out.println("Successful run of CoreNLP on a simple example.");
		getSentencewiseSentiment(document);
	}

	private static void getSentencewiseSentiment(Annotation document) {
		for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class)) {
			int mainSentiment = getSentiment(sentence);
			showResult(sentence.toString(), mainSentiment);
		}
	}

	private static int getSentiment(CoreMap sentence) {
		Tree tree = sentence.get(SentimentCoreAnnotations.AnnotatedTree.class);
	    return RNNCoreAnnotations.getPredictedClass(tree);
	}

	private static void showResult(String sentence, int sentiment) {
		StringBuilder sb = new StringBuilder();
		sb.append(sentence + " : " + SENTIMENT_VALUES[sentiment]);
	    System.out.println(sb.toString());
	}
}
