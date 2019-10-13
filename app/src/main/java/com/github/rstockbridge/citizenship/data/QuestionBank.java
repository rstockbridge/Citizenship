package com.github.rstockbridge.citizenship.data;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public final class QuestionBank {

    private static QuestionBank questionBank;

    @NonNull
    private List<Question> questions = new ArrayList<>();

    @NonNull
    public static QuestionBank getSharedInstance() {
        if (questionBank == null) {
            questionBank = new QuestionBank();
        }
        return questionBank;
    }

    private QuestionBank() {
        questions.add(new Question("What is the supreme law of the land?", "the Constitution", 0));
        questions.add(new Question("What does the Constitution do?", "- sets up the government\n" + "- defines the government\n" + "- protects basic rights of Americans", 1));
        questions.add(new Question("The idea of self-government is in the first three words of the Constitution. What are these words?", "We the People", 2));
        questions.add(new Question("What is an amendment?", "- a change (to the Constitution)\n" + "- an addition (to the Constitution)", 3));
        questions.add(new Question("What do we call the first ten amendments to the Constitution?", "the Bill of Rights", 4));
        questions.add(new Question("What is one right or freedom from the First Amendment?", "- speech\n" + "- religion\n" + "- assembly\n" + "- press\n" + "- petition the government", 5));
        questions.add(new Question("How many amendments does the Constitution have?", "twenty-seven (27)", 6));
        questions.add(new Question("What did the Declaration of Independence do?", "- announced our independence (from Great Britain)\n" + "- declared our independence (from Great Britain)\n" + "- said that the United States is free (from Great Britain)", 7));
        questions.add(new Question("What are two rights in the Declaration of Independence?", "- life\n" + "- liberty\n" + "- pursuit of happiness", 8));
        questions.add(new Question("What is freedom of religion?", "You can practice any religion, or not practice a religion.", 9));
        questions.add(new Question("What is the economic system in the United States?", "- capitalist economy\n" + "- market economy", 10));
        questions.add(new Question("What is the \"rule of law\"?", "- Everyone must follow the law.\n" + "- Leaders must obey the law.\n" + "- Government must obey the law.\n" + "- No one is above the law.", 11));
        questions.add(new Question("Name one branch or part of the government.", "- Congress\n" + "- legislative\n" + "- President\n" + "- executive\n" + "- the courts\n" + "- judicial", 12));
        questions.add(new Question("What stops one branch of government from becoming too powerful?", "- checks and balances\n" + "- separation of powers", 13));
        questions.add(new Question("Who is in charge of the executive branch?", "the President", 14));
        questions.add(new Question("Who makes federal laws?", "- Congress\n" + "- Senate and House (of Representatives)\n" + "- (U.S. or national) legislature", 15));
        questions.add(new Question("What are the two parts of the U.S. Congress?", "the Senate and House (of Representatives)", 16));
        questions.add(new Question("How many U.S. Senators are there?", "one hundred (100)", 17));
        questions.add(new Question("We elect a U.S. Senator for how many years?", "six (6)", 18));
        questions.add(new Question("Who is one of your state’s U.S. Senators now?", "- Gary Peters\n" + "- Debbie Stabenow", 19));
        questions.add(new Question("The House of Representatives has how many voting members?", "four hundred thirty-five (435)", 20));
        questions.add(new Question("We elect a U.S. Representative for how many years?", "two (2)", 21));
        questions.add(new Question("Name your U.S. Representative.", "David Trott", 22));
        questions.add(new Question("Who does a U.S. Senator represent?", "all people of the state", 23));
        questions.add(new Question("Why do some states have more Representatives than other states?", "- (because of) the state’s population\n" + "- (because) they have more people\n" + "- (because) some states have more people", 24));
        questions.add(new Question("We elect a President for how many years?", "four (4)", 25));
        questions.add(new Question("In what month do we vote for President?", "November", 26));
        questions.add(new Question("What is the name of the President of the United States now?", "- Donald J. Trump\n" + "- Donald Trump\n" + "- Trump", 27));
        questions.add(new Question("What is the name of the Vice President of the United States now?", "- Michael R. Pence\n" + "- Mike Pence\n" + "- Pence", 28));
        questions.add(new Question("If the President can no longer serve, who becomes President?", "the Vice President", 29));
        questions.add(new Question("If both the President and the Vice President can no longer serve, who becomes President?", "the Speaker of the House", 30));
        questions.add(new Question("Who is the Commander in Chief of the military?", "the President", 31));
        questions.add(new Question("Who signs bills to become laws?", "the President", 32));
        questions.add(new Question("Who vetoes bills?", "the President", 33));
        questions.add(new Question("What does the President’s Cabinet do?", "advises the President", 34));
        questions.add(new Question("What are two Cabinet-level positions?", "- Secretary of Agriculture\n" + "- Secretary of Commerce\n" + "- Secretary of Defense\n" + "- Secretary of Education\n" + "- Secretary of Energy\n" + "- Secretary of Health and Human Services\n" + "- Secretary of Homeland Security\n" + "- Secretary of Housing and Urban Development\n" + "- Secretary of the Interior\n" + "- Secretary of Labor\n" + "- Secretary of State\n" + "- Secretary of Transportation\n" + "- Secretary of the Treasury\n" + "- Secretary of Veterans Affairs\n" + "- Attorney General\n" + "- Vice President", 35));
        questions.add(new Question("What does the judicial branch do?", "- reviews laws\n" + "- explains laws\n" + "- resolves disputes (disagreements)\n" + "- decides if a law goes against the Constitution", 36));
        questions.add(new Question("What is the highest court in the United States?", "the Supreme Court", 37));
        questions.add(new Question("How many justices are on the Supreme Court?", "nine (9)", 38));
        questions.add(new Question("Who is the Chief Justice of the United States now?", "John Roberts (John G. Roberts, Jr.)", 39));
        questions.add(new Question("Under our Constitution, some powers belong to the federal government. What is one power of the federal government?", "- to print money\n" + "- to declare war\n" + "- to create an army\n" + "- to make treaties", 40));
        questions.add(new Question("Under our Constitution, some powers belong to the states. What is one power of the states?", "- provide schooling and education\n" + "- provide protection (police)\n" + "- provide safety (fire departments)\n" + "- give a driver’s license\n" + "- approve zoning and land use", 41));
        questions.add(new Question("Who is the Governor of your state now?", "Rick Snyder", 42));
        questions.add(new Question("What is the capital of your state?", "Lansing", 43));
        questions.add(new Question("What are the two major political parties in the United States?", "Democratic and Republican\n", 44));
        questions.add(new Question("What is the political party of the President now?", "Republican (Party)", 45));
        questions.add(new Question("What is the name of the Speaker of the House of Representatives now?", "- Paul D. Ryan\n" + "- (Paul) Ryan", 46));
        questions.add(new Question("There are four amendments to the Constitution about who can vote. Describe one of them.", "- Citizens eighteen (18) and older (can vote).\n" + "- You don’t have to pay (a poll tax) to vote.\n" + "- Any citizen can vote. (Women and men can vote.)\n" + "- A male citizen of any race (can vote).", 47));
        questions.add(new Question("What is one responsibility that is only for United States citizens?", "- serve on a jury\n" + "- vote in a federal election", 48));
        questions.add(new Question("Name one right only for United States citizens.", "- vote in a federal election\n" + "- run for federal office", 49));
        questions.add(new Question("What are two rights of everyone living in the United States?", "- freedom of expression\n" + "- freedom of speech\n" + "- freedom of assembly\n" + "- freedom to petition the government\n" + "- freedom of religion\n" + "- the right to bear arms\n", 50));
        questions.add(new Question("What do we show loyalty to when we say the Pledge of Allegiance?", "- the United States\n" + "- the flag", 51));
        questions.add(new Question("What is one promise you make when you become a United States citizen?", "- give up loyalty to other countries\n" + "- defend the Constitution and laws of the United States\n" + "- obey the laws of the United States\n" + "- serve in the U.S. military (if needed)\n" + "- serve (do important work for) the nation (if needed)\n" + "- be loyal to the United States", 52));
        questions.add(new Question("How old do citizens have to be to vote for President?", "eighteen (18) and older", 53));
        questions.add(new Question("What are two ways that Americans can participate in their democracy?", "- vote\n" + "- join a political party\n" + "- help with a campaign\n" + "- join a civic group\n" + "- join a community group\n" + "- give an elected official your opinion on an issue\n" + "- call Senators and Representatives\n" + "- publicly support or oppose an issue or policy\n" + "- run for office\n" + "- write to a newspaper", 54));
        questions.add(new Question("When is the last day you can send in federal income tax forms?", "April 15", 55));
        questions.add(new Question("When must all men register for the Selective Service?", "- at age eighteen (18)\n" + "- between eighteen (18) and twenty-six (26)", 56));
        questions.add(new Question("What is one reason colonists came to America?", "- freedom\n" + "- political liberty\n" + "- religious freedom\n" + "- economic opportunity\n" + "- practice their religion\n" + "- escape persecution", 57));
        questions.add(new Question("Who lived in America before the Europeans arrived?", "- American Indians\n" + "- Native Americans\n", 58));
        questions.add(new Question("What group of people was taken to America and sold as slaves?", "- Africans\n" + "- people from Africa", 59));
        questions.add(new Question("Why did the colonists fight the British?", "- because of high taxes (taxation without representation)\n" + "- because the British army stayed in their houses (boarding, quartering)\n" + "- because they didn’t have self-government", 60));
        questions.add(new Question("Who wrote the Declaration of Independence?", "(Thomas) Jefferson", 61));
        questions.add(new Question("When was the Declaration of Independence adopted?", "July 4, 1776", 62));
        questions.add(new Question("There were 13 original states. Name three.", "- New Hampshire\n" + "- Massachusetts\n" + "- Rhode Island\n" + "- Connecticut\n" + "- New York\n" + "- New Jersey\n" + "- Pennsylvania\n" + "- Delaware\n" + "- Maryland\n" + "- Virginia\n" + "- North Carolina\n" + "- South Carolina\n" + "- Georgia", 63));
        questions.add(new Question("What happened at the Constitutional Convention?", "- The Constitution was written.\n" + "- The Founding Fathers wrote the Constitution.", 64));
        questions.add(new Question("When was the Constitution written?", "1787", 65));
        questions.add(new Question("The Federalist Papers supported the passage of the U.S. Constitution. Name one of the writers.", "- (James) Madison\n" + "- (Alexander) Hamilton\n" + "- (John) Jay\n" + "- Publius\n", 66));
        questions.add(new Question("What is one thing Benjamin Franklin is famous for?", "- U.S. diplomat\n" + "- oldest member of the Constitutional Convention\n" + "- first Postmaster General of the United States\n" + "- writer of “Poor Richard’s Almanac”\n" + "- started the first free libraries", 67));
        questions.add(new Question("Who is the “Father of Our Country”?", "(George) Washington", 68));
        questions.add(new Question("Who was the first President?", "(George) Washington", 69));
        questions.add(new Question("What territory did the United States buy from France in 1803?", "- the Louisiana Territory\n" + "- Louisiana", 70));
        questions.add(new Question("Name one war fought by the United States in the 1800s.", "- War of 1812\n" + "- Mexican-American War\n" + "- Civil War\n" + "- Spanish-American War", 71));
        questions.add(new Question("Name the U.S. war between the North and the South.", "- the Civil War\n" + "- the War between the States", 72));
        questions.add(new Question("Name one problem that led to the Civil War.", "- slavery\n" + "- economic reasons\n" + "- states’ rights", 73));
        questions.add(new Question("What was one important thing that Abraham Lincoln did?", "- freed the slaves (Emancipation Proclamation)\n" + "- saved (or preserved) the Union\n" + "- led the United States during the Civil War", 74));
        questions.add(new Question("What did the Emancipation Proclamation do?", "- freed the slaves\n" + "- freed slaves in the Confederacy\n" + "- freed slaves in the Confederate states\n" + "- freed slaves in most Southern states", 75));
        questions.add(new Question("What did Susan B. Anthony do?", "- fought for women’s rights\n" + "- fought for civil rights\n", 76));
        questions.add(new Question("Name one war fought by the United States in the 1900s.", "- World War I\n" + "- World War II\n" + "- Korean War\n" + "- Vietnam War\n" + "- (Persian) Gulf War", 77));
        questions.add(new Question("Who was President during World War I?", "(Woodrow) Wilson", 78));
        questions.add(new Question("Who was President during the Great Depression and World War II?", "(Franklin) Roosevelt", 79));
        questions.add(new Question("Who did the United States fight in World War II?", "Japan, Germany, and Italy", 80));
        questions.add(new Question("Before he was President, Eisenhower was a general. What war was he in?", "World War II", 81));
        questions.add(new Question("During the Cold War, what was the main concern of the United States?", "Communism", 82));
        questions.add(new Question("What movement tried to end racial discrimination?", "civil rights (movement)", 83));
        questions.add(new Question("What did Martin Luther King, Jr. do?", "- fought for civil rights\n" + "- worked for equality for all Americans", 84));
        questions.add(new Question("What major event happened on September 11, 2001, in the United States?", "Terrorists attacked the United States.", 85));
        questions.add(new Question("Name one American Indian tribe in the United States.", "- Cherokee\n" + "- Navajo\n" + "- Sioux\n" + "- Chippewa\n" + "- Choctaw\n" + "- Pueblo\n" + "- Apache\n" + "- Iroquois\n" + "- Creek\n" + "- Blackfeet\n" + "- Seminole\n" + "- Cheyenne\n" + "- Arawak\n" + "- Shawnee\n" + "- Mohegan\n" + "- Huron\n" + "- Oneida\n" + "- Lakota\n" + "- Crow\n" + "- Teton\n" + "- Hopi\n" + "- Inuit", 86));
        questions.add(new Question("Name one of the two longest rivers in the United States.", "- Missouri (River)\n" + "- Mississippi (River)", 87));
        questions.add(new Question("What ocean is on the West Coast of the United States?", "Pacific (Ocean)", 88));
        questions.add(new Question("What ocean is on the East Coast of the United States?", "Atlantic (Ocean)", 89));
        questions.add(new Question("Name one U.S. territory.", "- Puerto Rico\n" + "- U.S. Virgin Islands\n" + "- American Samoa\n" + "- Northern Mariana Islands\n" + "- Guam", 90));
        questions.add(new Question("Name one state that borders Canada.", "- Maine\n" + "- New Hampshire\n" + "- Vermont\n" + "- New York\n" + "- Pennsylvania\n" + "- Ohio\n" + "- Michigan\n" + "- Minnesota\n" + "- North Dakota\n" + "- Montana\n" + "- Idaho\n" + "- Washington\n" + "- Alaska", 91));
        questions.add(new Question("Name one state that borders Mexico.", "- California\n" + "- Arizona\n" + "- New Mexico\n" + "- Texas", 92));
        questions.add(new Question("What is the capital of the United States?", "Washington, D.C.", 93));
        questions.add(new Question("Where is the Statue of Liberty?", "- New York (Harbor)\n" + "- Liberty Island", 94));
        questions.add(new Question("Why does the flag have 13 stripes?", "- because there were 13 original colonies\n" + "- because the stripes represent the original colonies", 95));
        questions.add(new Question("Why does the flag have 50 stars?", "- because there is one star for each state\n" + "- because each star represents a state\n" + "- because there are 50 states", 96));
        questions.add(new Question("What is the name of the national anthem?", "The Star-Spangled Banner", 97));
        questions.add(new Question("When do we celebrate Independence Day?", "July 4", 98));
        questions.add(new Question("Name two national U.S. holidays.", "- New Year’s Day\n" + "- Martin Luther King, Jr. Day\n" + "- Presidents’ Day\n" + "- Memorial Day\n" + "- Independence Day\n" + "- Labor Day\n" + "- Columbus Day\n" + "- Veterans Day\n" + "- Thanksgiving\n" + "- Christmas", 99));
    }

    @NonNull
    public List<Question> getAllQuestions() {
        return new ArrayList<>(questions);
    }

    @NonNull
    public ArrayList<Question> getQuestionsFromId(@NonNull final List<Integer> listOfIds) {
        final ArrayList<Question> result = new ArrayList<>();

        for (final Question question : questions) {
            if (listOfIds.contains(question.getId())) {
                result.add(question);
            }
        }

        return result;
    }
}
