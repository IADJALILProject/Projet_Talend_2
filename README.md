1) Objectifs

Module Talend packagé (.jar) avec scripts .bat/.ps1, log4j2, audit/rejects, orchestration Airflow/k8s CronJobs, monitoring.

2) Exécution
# Windows
run\Module_Extract.ps1 && run\Module_Load.ps1
# Linux
bash run/module_extract.sh && bash run/module_load.sh

3) Intégrations

Airflow: BashOperator/KubernetesPodOperator.

k8s CronJobs pour le scheduling.

Prometheus exporter (durées, rows, erreurs) + Grafana.

4) Audit & Qualité

Tables etl_audit, etl_rejects, KPI rejets, redéclenchement idempotent.

5) Sécurité

Contexts séparés, secrets externalisés, RBAC DB.

6) Troubleshooting

JAR exit code ≠ 0 → lire logs/ via log4j2.

Connexion DB → vérifier contexts/*.properties.
