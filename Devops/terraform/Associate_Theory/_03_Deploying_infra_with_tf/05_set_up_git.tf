provider "github" {
  token = "github_pat_11AP75YKQ049uT7T3oMKkB" # or `GITHUB_TOKEN`
}

resource "github_repository" "terraformDemo" {
  name        = "terraformDemo"
  description = "My awesome terraform demo"
  visibility = "public"

}