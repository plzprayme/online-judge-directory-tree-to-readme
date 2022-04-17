FROM dbfpzk142/online-judge-readme-auto-formatter:latest

COPY entrypoint.sh /entrypoint.sh

RUN chmod +x /entrypoint.sh
ENTRYPOINT ["/entrypoint.sh"]