import React, { useEffect, useState } from "react";
import { Client } from "@stomp/stompjs";
import SockJS from "sockjs-client";

interface AdmProps {
  title: string;
}

const Adm: React.FC<AdmProps> = ({ title }) => {
  const [message, setMessage] = useState<string | null>(null);

  useEffect(() => {
    const socket = new SockJS("http://localhost:8081/ws");
    const stompClient = new Client({
      webSocketFactory: () => socket,
      debug: (str) => console.log(str),
      onConnect: () => {
        stompClient.subscribe("/topic/notifications/adm", (message) => {
          if (message.body) {
            setMessage(message.body);
            setTimeout(() => {
              setMessage(null);
            }, 5000);
          }
        });
      },
    });

    stompClient.activate();

    return () => {
      stompClient.deactivate();
    };
  }, []);

  return (
    <div>
      <div className="font-bold text-white text-center">{title}</div>
      {message && <div className="fade-in-out text-center">{message}</div>}
    </div>
  );
};

export default Adm;
