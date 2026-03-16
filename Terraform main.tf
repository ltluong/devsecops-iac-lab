provider "google" {
 project = "devsecops-iac-lab"
 region  = "asia-southeast1"
}

resource "google_compute_instance" "jenkins" {
 name         = "jenkins-server"
 machine_type = "e2-medium"
 zone         = "asia-southeast1-a"

 boot_disk {
   initialize_params {
     image = "debian-cloud/debian-11"
   }
 }

 network_interface {
   network = "default"

   access_config {
   }
 }

 tags = ["jenkins"]
}