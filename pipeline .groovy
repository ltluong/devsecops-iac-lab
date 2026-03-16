pipeline {

agent any

stages {

stage('Checkout'){
steps{
git 'https://github.com/devsecops/iac-lab'
}
}

stage('Security Scan'){
steps{
sh 'checkov -d terraform/'
}
}

stage('Terraform Init'){
steps{
sh 'terraform init'
}
}

stage('Terraform Plan'){
steps{
sh 'terraform plan'
}
}

stage('Deploy'){
steps{
sh 'terraform apply -auto-approve'
}
}

}

}