import { TestBed } from '@angular/core/testing';

import { SendAnswersService } from './send-answers.service';

describe('SendAnswersService', () => {
  let service: SendAnswersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SendAnswersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
