package ro.jademy.millionaire.data;

import ro.jademy.millionaire.model.Answer;
import ro.jademy.millionaire.model.Question;

import java.util.Arrays;
import java.util.List;

public class QuestionProvider {
    public static List<Question> ALL_QUESTIONS = Arrays.asList(
            new Question("What sort of animal is Walt Disney's Dumbo?", Arrays.asList(
                    new Answer("Deer"),
                    new Answer("Rabbit"),
                    new Answer("Donkey")
            ), new Answer("Elephant"), 0),
            new Question("In children’s stories, how many wishes are granted by a genie or fairy?", Arrays.asList(
                    new Answer("One"),
                    new Answer("Two"),
                    new Answer("Four")
            ), new Answer("Three"), 0),
            new Question("Which of these is a type of hat?", Arrays.asList(
                    new Answer("Sausage roll"),
                    new Answer("Scotch egg"),
                    new Answer("Potato crisp")
            ), new Answer("Pork pie"), 0),
            new Question("Where does a cowboy wear chaps?", Arrays.asList(
                    new Answer("On his head"),
                    new Answer("On his arms"),
                    new Answer("On his hands")
            ), new Answer("On his legs"), 0),
            new Question("How many seconds are in a minute?", Arrays.asList(
                    new Answer("30"),
                    new Answer("1"),
                    new Answer("300")
            ), new Answer("60"), 0),
            new Question("What city contains the Eiffel Tower?", Arrays.asList(
                    new Answer("Sydney"),
                    new Answer("Los Angeles"),
                    new Answer("New York City")
            ), new Answer("Paris"), 0),
            new Question("Who was the first man to travel into space twice?", Arrays.asList(
                    new Answer("Vladimir Titov"),
                    new Answer("Michael Collins"),
                    new Answer("Yuri Gagarin")
            ), new Answer("Gus Grissom"), 1),
            new Question("Who wasn't a member of the Beatles?", Arrays.asList(
                    new Answer("John Lenon"),
                    new Answer("Paul McCartney"),
                    new Answer("Ringo Star")
            ), new Answer("Justin Timberlake"), 1),
            new Question("Which of the following is not a type of pasta?", Arrays.asList(
                    new Answer("Spaghetti"),
                    new Answer("Fettuccine"),
                    new Answer("Ziti")
            ), new Answer("Escargot"), 1),
            new Question("Which state has cities named San Francisco and Hollywood?", Arrays.asList(
                    new Answer("Utah"),
                    new Answer("Hawaii"),
                    new Answer("Montana")
            ), new Answer("California"), 1),
            new Question("Which one of the following is not an Ivy League University?", Arrays.asList(
                    new Answer("Harvard"),
                    new Answer("Princeton"),
                    new Answer("Columbia")
            ), new Answer("Hogwarts"), 1),
            new Question("Which American car company makes the Mustang, the F-150 and Escape?", Arrays.asList(
                    new Answer("Toyota"),
                    new Answer("Volkswagen"),
                    new Answer("Nissan")
            ), new Answer("Ford"), 1),
            new Question("Who was the first woman to fly solo across the Atlantic?", Arrays.asList(
                    new Answer("Geraldine Ferraro"),
                    new Answer("Martha Stewart"),
                    new Answer("Sally Ride")
            ), new Answer("Amelia Earhart"), 2),
            new Question("Which U.S. city is home to the Liberty Bell and Independence Hall?", Arrays.asList(
                    new Answer("Vancouver"),
                    new Answer("Mexico City"),
                    new Answer("Beijing")
            ), new Answer("Philadelphia"), 2),
            new Question("A number 1, followed by one hundred zeroes is known by what name?", Arrays.asList(
                    new Answer("Megatron"),
                    new Answer("Gigabit"),
                    new Answer("Nanomole")
            ), new Answer("Googol"), 2),
            new Question("In 1581, Sir Francis Drake became mayor of which city?", Arrays.asList(
                    new Answer("Hull"),
                    new Answer("Glasgow"),
                    new Answer("Bristol")
            ), new Answer("Plymouth"), 2),
            new Question("Which of these have to pass a test on ‘The Knowledge’ to get a licence?", Arrays.asList(
                    new Answer("Bus drivers"),
                    new Answer("Police officers"),
                    new Answer("Ambulance drivers")
            ), new Answer("Taxi drivers"), 2),
            new Question("Which toxic substance is obtained from the pressed seeds of the castor oil plant?", Arrays.asList(
                    new Answer("Sarin"),
                    new Answer(" Strychnine"),
                    new Answer("Cyanide")
            ), new Answer("Ricin"), 2),
            new Question("In Welsh, what does ‘afon’ mean?", Arrays.asList(
                    new Answer("Fort"),
                    new Answer("Meadow"),
                    new Answer("Pool")
            ), new Answer("River"), 3),
            new Question("Which king wrote a famous denunciation of smoking?", Arrays.asList(
                    new Answer("Richard I"),
                    new Answer("William I"),
                    new Answer("George I")
            ), new Answer("James I"), 3),
            new Question("The young of which creature is known as a squab?", Arrays.asList(
                    new Answer("Salmon"),
                    new Answer("Horse"),
                    new Answer("Octopus")
            ), new Answer("Pigeon"), 3),
            new Question("Who is the patron saint of Spain?", Arrays.asList(
                    new Answer("St John"),
                    new Answer("St Benedict"),
                    new Answer("St Peter")
            ), new Answer("St James"), 3),
            new Question("Which of these is not one of the American Triple Crown horse races?", Arrays.asList(
                    new Answer("Belmont Stakes"),
                    new Answer("Kentucky Derby"),
                    new Answer("Preakness Stakes")
            ), new Answer("Arlington Million"), 3),
            new Question("In the history of motor sport, which of these iconic races was held first?", Arrays.asList(
                    new Answer("Le Mans 24 Hours"),
                    new Answer("Monaco Grand Prix"),
                    new Answer("Indy 500")
            ), new Answer("Isle of Man TT"), 3),
            new Question("In 1912, former US President Theodore Roosevelt was a candidate for which political party?", Arrays.asList(
                    new Answer("Bull Dog"),
                    new Answer("Bull Dog"),
                    new Answer("Bull Elephant")
            ), new Answer("Bull Moose"), 3)
    );
}
