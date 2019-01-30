import { TestBed } from '@angular/core/testing';

import { RoleLogService } from './roleLog.service';

describe('RoleLogService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RoleLogService = TestBed.get(RoleLogService);
    expect(service).toBeTruthy();
  });
});
