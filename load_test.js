import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
  stages: [
    { duration: '5m', target: 5 }, // Первая ступень: 5 rps в течение 5 минут
    { duration: '5m', target: 10 }, // Вторая ступень: 10 rps в течение 5 минут
  ],
};

export default function () {
  const url = 'http://localhost:8080/send-to-kafka';

  const payload = JSON.stringify({
    userId: 'user_id', 
  });

  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  http.post(url, payload, params);

  sleep(1);
}
