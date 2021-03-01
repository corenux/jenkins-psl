def call(Map config=[:], Closure body) {
    node('pipeline') {
        git url: "https://github.com/corenux/sample-nodejs"

        stage("Install") {
            sh "npm install"
        }

        stage("Test") {
            sh "npm test"
        }

        stage("Deploy") {
            if (config.deploy) {
                sh "npm publish"
            }
        }

        body()
    }
}
