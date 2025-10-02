FROM node:20

WORKDIR /frontend

COPY package*.json ./
COPY . .

RUN npm install

EXPOSE 4200

CMD ["npm", "start"]