import { TestBed } from '@angular/core/testing';

import { TeamMemberService } from './teamMember.service';

describe('RoleLogService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TeamMemberService = TestBed.get(TeamMemberService);
    expect(service).toBeTruthy();
  });
});
