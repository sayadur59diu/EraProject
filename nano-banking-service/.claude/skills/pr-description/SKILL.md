# PR Description Skill

Generate a clear, structured pull request description for the current branch based on the actual diff and commit history.

## How to run

1. Run `git log main..HEAD --oneline` to list commits on this branch.
2. Run `git diff main...HEAD` to inspect all changed files and lines.
3. Identify the type of change: feature, fix, refactor, chore, docs, test.
4. Write the PR description using the output format below.

---

## Rules

- **Title:** ≤ 70 characters. Start with a verb (Add, Fix, Remove, Refactor, Update). No period at the end.
- **Summary bullets:** 1–4 bullets covering *what* changed and *why*. Skip obvious implementation details.
- **Test plan:** Concrete checklist items — what a reviewer can actually run or check. If no tests exist, say so honestly.
- **Breaking changes:** Only include this section if the diff changes a public API, removes a field, or alters DB schema in a non-additive way.
- Do not pad the description. Omit any section that has nothing meaningful to say.
- Reference issue numbers if they appear in commit messages (e.g., `Closes #42`).

---

## Output Format

```
<title>

## Summary
- <bullet>
- <bullet>

## Test plan
- [ ] <step>
- [ ] <step>

## Breaking changes  ← omit if none
- <description>

🤖 Generated with [Claude Code](https://claude.com/claude-code)
```

---

## Examples

### Feature addition
```
Add account balance endpoint to account-service

## Summary
- Adds `GET /accounts/{id}/balance` returning current balance and currency
- Introduces `BalanceResponse` DTO to keep the entity out of the API contract

## Test plan
- [ ] `GET /accounts/1/balance` returns 200 with correct balance for an existing account
- [ ] `GET /accounts/999/balance` returns 404 with ApiResponse error body
- [ ] Confirm response shape matches `ApiResponse<BalanceResponse>`
```

### Bug fix
```
Fix hardcoded DB host in customer-service properties

## Summary
- Replaces `10.11.201.120` with `${DB_HOST:localhost}` so Docker and local environments both work without manual edits

## Test plan
- [ ] `docker-compose up customer-service` connects successfully (uses `oracle-db` hostname via env)
- [ ] Running locally without env var connects to `localhost:1522`
```
