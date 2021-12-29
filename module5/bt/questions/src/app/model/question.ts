import {QuestionType} from './question-type';

export class Question {
  id: number;
  title: string;
  question_type: QuestionType;
  questionSentence: string;
  answer: number;
  dateCreate: string;
  status: string;
}
