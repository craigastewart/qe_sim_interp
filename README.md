# qe_sim_interp
A modified version of Quest++ (Specia et al, 2015)<sup>1</sup> for use in evaluation of simultaneous interpreter performance

For a full explanation of Quest++ and relevant installation instructions and tutorials please refer to https://www.quest.dcs.shef.ac.uk

# Modifications to the code include:

Addition of the following files:

**/config/config.sentence-level_es_sim_interp.properties** as an example modification of existing sentence level configuration for use with interpreter features

**/config/features/features_sim_interp.xml** being the feature configuration file reflecting the experimental setup in Stewart et al (2018)<sup>2</sup>

**src/shef/mt/features/impl/bb/Feature[7001-7007].java** representing the individual implemented features

Modifications to **src/shef/mt/features/tools/SentenceLevelProcessorFactory.java** to reflect new feature implementation

# References

<sup>1</sup>Lucia Specia, Gustavo Henrique Paetzold and Carolina Scarton (2015): Multi-level Translation Quality Prediction with QuEst++. In the Proceedings of ACL-IJCNLP 2015 System Demonstrations, Beijing, China, pp. 115-120.

<sup>2</sup>Craig Stewart, Nikolai Vogler, Junjie Hu, Jordan Boyd-Graber, Graham Neubig (2018): Automatic Estimation of Simultaneous Interpreter Performance. The 56th Annual Meeting of the Association for Computational Linguistics (ACL). Melbourne, Australia. July 2018 (To Appear).
