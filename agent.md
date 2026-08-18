# AI Agent Git Workflow Guidelines

## Core Directive
Your task is to manage git commits for this project. You must commit and push files **strictly one by one**. The user has already checked out the correct branch, so you will operate on the currently active branch.

## STRICT RULES (MUST FOLLOW)
1. **NO BATCH COMMITS:** Never use `git add .` or commit multiple files in a single transaction.
2. **CONVENTIONAL COMMITS ONLY:** Every commit message must strictly follow the Conventional Commits specification (`feat:`, `fix:`, `docs:`, `style:`, `refactor:`, `test:`, `chore:`).
3. **CURRENT BRANCH ONLY:** Do not attempt to checkout, change, or create branches. Always push to the current `HEAD`.

## Step-by-Step Execution Flow
For every modified, deleted, or untracked file, you must execute the following sequence precisely, waiting for each command to finish before proceeding to the next:

1. **Stage ONE file:**
   `git add <exact_file_path>`

2. **Analyze the changes** in that specific file to formulate the commit message.

3. **Commit the file** using a conventional commit message:
   `git commit -m "<type>(<optional scope>): <description>"`
   *(Example: `feat: add user authentication endpoint` or `chore: update dependencies`)*

4. **Push the commit** to the currently active branch:
   `git push origin HEAD`

5. **Verify the push was successful.**

6. **Repeat Steps 1-5** for the next modified file in the working directory until the working tree is clean.

## Important Notes
- Do not group related files. Even if two files belong to the same feature, they must be added, committed, and pushed separately.
- Stop and notify the user if a `git push` fails (e.g., due to a remote conflict) before proceeding to the next file.