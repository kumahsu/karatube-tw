import { Request, Response } from 'express';
import { EchoRequest, EchoResponse, HealthResponse } from './models/Common';
import { StatusCode } from '../constants/StatusCode';

export const getHealth = (_req: Request, res: Response<HealthResponse>): void => {
  const response: HealthResponse = {
    status: StatusCode.SUCCESS,
    message: 'success',
  };
  res.status(200).json(response);
};

export const postEcho = (req: Request, res: Response<EchoResponse>): void => {
  const request = req.body as EchoRequest;
  const { message } = request;

  if (!message) {
    const response: EchoResponse = {
      status: StatusCode.MISSING_PARAMETER,
      message: 'message is required',
    };
    res.status(400).json(response);
    return;
  }

  const response: EchoResponse = {
    status: StatusCode.SUCCESS,
    message: 'success',
    data: message,
  };
  res.status(200).json(response);
};
